package cn.edu.zhku.oa.manager.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zhku.oa.manager.InitSystemDatas;
import cn.edu.zhku.oa.manager.OrgManager;
import cn.edu.zhku.oa.manager.UserManager;
import cn.edu.zhku.oa.model.ACL;
import cn.edu.zhku.oa.model.Module;
import cn.edu.zhku.oa.model.Organization;
import cn.edu.zhku.oa.model.Permission;
import cn.edu.zhku.oa.model.Person;
import cn.edu.zhku.oa.model.Role;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.web.SystemException;

public class InitSystemDatasImpl extends HibernateDaoSupport implements
		InitSystemDatas {

	private static Log logger = LogFactory.getLog(InitSystemDatasImpl.class);
	private String file;
	private OrgManager orgManager;
	private UserManager userManager;
	
	@Override
	public void addOrUpdateInitDatas(String xmlFilePath) {
		try{
			String filePath = null;
			if(xmlFilePath == null || xmlFilePath.trim().equals("")){
				filePath = file;
			}else{
				filePath = xmlFilePath;
			}
			
			//ʹ��Dom4j��ȡxml�ļ�
			Document document = new SAXReader().read(
				Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)
			);
			
			this.importModules(document.selectNodes("//Modules/Module"),null);
			this.importRoleAndAcl(document.selectNodes("//Roles/Role"));
			this.importOrgAndPerson(document.selectNodes("//Organizations/Org"), null);
		}catch(Exception e){
			e.printStackTrace();
			throw new SystemException("��ʼ���������� ����!");
		}
	}
	
	//����ģ����Ϣ
	protected void importModules(List modules,Module parent){
		for(Iterator iter = modules.iterator(); iter.hasNext();){
			Element element = (Element)iter.next();
			Module module = new Module();
			module.setName(element.attributeValue("name"));
			module.setSn(element.attributeValue("sn"));
			module.setUrl(element.attributeValue("url"));
			module.setOrderNo(Integer.parseInt(element.attributeValue("orderNo")));
			module.setParent(parent);
			getHibernateTemplate().save(module);
			logger.info("����ģ�顾"+module.getName()+"��");
			importModules(element.selectNodes("Module"),module);
		}
	}
	
	protected void importRoleAndAcl(List roles){
		for (Iterator iter = roles.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Role role = new Role();
			role.setName(element.attributeValue("name"));
			getHibernateTemplate().save(role);
			
			//����ɫ��Ȩ
			List acls = element.selectNodes("Acl");
			for (Iterator iterator = acls.iterator(); iterator.hasNext();) {
				Element aclElem = (Element) iterator.next();
				Integer moduleId = 
					(Integer)getSession()
					.createQuery("select m.id from Module m where m.name = ?")
					.setParameter(0, aclElem.attributeValue("module"))
					.uniqueResult();
				ACL acl = new ACL();
				acl.setPrincipalType(ACL.TYPE_ROLE);
				acl.setPrincipalSn(role.getId());
				acl.setResourceSn(moduleId);
				if("true".equals(aclElem.attributeValue("C"))){
					acl.setPermission(Permission.CREATE, true);
				}
				if("true".equals(aclElem.attributeValue("R"))){
					acl.setPermission(Permission.READ, true);
				}
				if("true".equals(aclElem.attributeValue("U"))){
					acl.setPermission(Permission.UPDATE, true);
				}
				if("true".equals(aclElem.attributeValue("D"))){
					acl.setPermission(Permission.DELETE, true);
				}
				getHibernateTemplate().save(acl);
			}
		}
	}
	
	protected void importOrgAndPerson(List orgs,Organization parent){
		for (Iterator iter = orgs.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Organization org = new Organization();
			org.setName(element.attributeValue("name"));
			orgManager.addOrg(org, parent == null?0:parent.getId());
			
			//���һ����µ���Ա��Ϣ������ʼ��
			List persons = element.selectNodes("Person");
			for (Iterator iterator = persons.iterator(); iterator.hasNext();) {
				Element personElem = (Element) iterator.next();
				Person person = new Person();
				person.setName(personElem.attributeValue("name"));
				person.setOrg(org);
				getHibernateTemplate().save(person);
				
				//����Ա�����½�ʺ�
				User user = new User();
				user.setUsername(personElem.attributeValue("username"));
				user.setPassword(personElem.attributeValue("password"));
				user.setPerson(person);
				getHibernateTemplate().save(user);
				
				//���û������ɫ
				String roles = personElem.attributeValue("roles");
				String[] roleNames = roles.split(",");
				for(int i=0; i<roleNames.length; i++){
					int roleId = 
						(Integer)getSession()
						.createQuery("select r.id from Role r where r.name = ?")
						.setParameter(0, roleNames[i])
						.uniqueResult();
					userManager.addOrUpdateUserRole(user.getId(), roleId, i+1);
					
				}
			}
			
			//��ʼ���˻����µ��ӻ�����Ϣ
			importOrgAndPerson( element.selectNodes("Org") , org);
		}
	}
	
	
	public void setFile(String file) {
		this.file = file;
	}


	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
