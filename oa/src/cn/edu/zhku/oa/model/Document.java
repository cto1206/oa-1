package cn.edu.zhku.oa.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import cn.edu.zhku.oa.manager.SystemException;

/**
 * ����
 * ���ߣ���Ȩ
 * @hibernate.class table="t_document"
 */
public class Document {
	public final static String STATUS_NEW = "�½�";
	public final static String STATUS_END = "���";
	
	private Logger logger = Logger.getLogger(Document.class);
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String title;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String description;
	
	/**
	 * �������ݣ����ϴ��ļ������ݣ�
	 * ��Щ�ϴ��ļ������ݽ��ᱻ���浽���ݿ�
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] content;
	
	/**
	 * ������
	 * @hibernate.many-to-one
	 */
	private User creator;
	
	/**
	 * ����ʱ��
	 * @hibernate.property
	 */
	private Date createTime;
	
	/**
	 * �������ߵ�����
	 * @hibernate.many-to-one
	 */
	private Workflow workflow;
	
	/**
	 * ����ʵ���ı�ʶ
	 * @hibernate.property
	 */
	private long processInstanceId;
	
	/**
	 * ���ĵĵ�ǰ״̬��Ϣ��
	 * ֻ���½�״̬�Ĺ��ģ��ſ��Ա����º�ɾ��
	 * ֻ�������״̬�Ĺ��ģ��ſ��Ա��鵵
	 * @hibernate.property
	 */
	private String status;
	
	/**
	 * ���Ķ�̬����, key:String, value:DocumentProperty
	 * @hibernate.map table="t_document_properties"
	 * @hibernate.key column="documentId"
	 * @hibernate.map-key type="string" column="propertyName"
	 * @hibernate.composite-element class="cn.edu.zhku.oa.model.DocumentProperty"
	 */
	private Map props;
	
	//�ӽ����Ͻ��չ����ĸ�������ֵ������δת��֮ǰ��ֵ
	public void setPropertiesMap(Map props){
		if(workflow.getFlowForm() == null){  
			return;
		}
		Set fields = workflow.getFlowForm().getFields();
		FormField formField = null;
		for (Iterator iterator = fields.iterator(); iterator.hasNext();) {
			FormField field = (FormField) iterator.next();
			setProperty(field.getFieldName(),props.get(field.getFieldName()));
		}
	}
	
	//���ö�Ӧ������
	public void setProperty(String name,Object value){

		try {
			//FieldType��type���Ա�����DocumentProperty���е���������һ�£�
			String type = getPropertyType(name);
			DocumentProperty dp = new DocumentProperty();
			if(!DocumentProperty.support(type)){
				throw new SystemException("��֧�ֵ��������ͣ�");
			}
			
			//������Ӧ��Converter������
			BeanUtils.copyProperty(dp, type, value);
			
			if(props == null){
				props = new HashMap();
			}
			props.put(name, dp);
			
		} catch (Exception e) {
			throw new SystemException("�������Ե�ʱ������쳣��",e);
		}
	}
	
	//��ȡ��Ӧ������
	public Object getProperty(String name){
		//���ݶ�Ӧ��fieldType����DocumentPropertyת��Ϊ��Ӧ�����ͣ�������
		try {
			if(props == null){
				return null;
			}
			DocumentProperty dp = (DocumentProperty)props.get(name);
			String type = getPropertyType(name);
			
			return PropertyUtils.getProperty(dp, type);
			
		} catch (Exception e) {
			throw new SystemException("��ȡ��������["+name+"]��ʱ�����쳣��",e);
		}
		
	}
	
	//��ö�Ӧ���Ե���������
	private String getPropertyType(String name){
		//����ݶ�ӦfieldType��ת��Ϊ��Ӧ������(DocumentProperty)�����洢
		try {
			Set fields = workflow.getFlowForm().getFields();
			FormField formField = null;
			for (Iterator iterator = fields.iterator(); iterator.hasNext();) {
				FormField field = (FormField) iterator.next();
				if(field.getFieldName().equals(name)){
					formField = field;
					break;
				}
			}
			
			//��ö�Ӧ���Ե���������
			return formField.getFieldType().getType();
			
		} catch (Exception ignore) {
			logger.warn("��ȡ��Ӧ����["+name+"]����������ʱ�����쳣��",ignore);
		}
		
		throw new SystemException("�޷���ö�Ӧ���Ե���������");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public long getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map getProps() {
		return props;
	}

	public void setProps(Map props) {
		this.props = props;
	}
	
}
