package cn.edu.zhku.oa.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.manager.PersonManager;
import cn.edu.zhku.oa.manager.RoleManager;
import cn.edu.zhku.oa.manager.UserManager;
import cn.edu.zhku.oa.model.MailUser;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.web.forms.UserActionForm;

public class UserAction extends DispatchAction {
	
	private PersonManager personMgr;
	private UserManager userMgr;
	private RoleManager roleMgr;
	
	//��ҳ����ʾ��Ա�б�
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm", personMgr.searchPersons());
		
		return mapping.findForward("index");
	}
	
	//����ӽ���	
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("add_input");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		
		BeanUtils.copyProperties(user, uaf);
		
		userMgr.addUser(user, uaf.getPersonId());
		
		return mapping.findForward("pub_add_success");
	}
	
	//�򿪸��½���	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		request.setAttribute("user", userMgr.findUser(uaf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		
		BeanUtils.copyProperties(user, uaf);
		
		userMgr.updateUser(user, uaf.getPersonId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward updatePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		userMgr.updatePassword(uaf.getId(), uaf.getOldPassword(), uaf.getPassword());
		
		return mapping.findForward("done");
	}
	
	public ActionForward chgpsw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		User user = (User) request.getSession().getAttribute("login");
		
		request.setAttribute("user", userMgr.findUser(user.getId()));
		
		return mapping.findForward("password_input");
		
	}
	
	//���û����н�ɫ���б�ҳ�棬��ҳ������Ҫ��ʾ���û����������Լ��û���ӵ�еĽ�ɫ�б�
	public ActionForward userRoleList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = userMgr.findUser(uaf.getId());
		
		//��Ҫ�����ѷ�����û��Ľ�ɫ�б�
		List userRoleList = userMgr.searchUserRoles(uaf.getId());
		
		request.setAttribute("user", user);
		request.setAttribute("urs", userRoleList);
		
		return mapping.findForward("user_role_list");
	}
	
	//�򿪸��û������ɫҳ�棺���ӽ�ɫ�б���ѡ��ĳ����ɫ�����������ȼ�
	public ActionForward userRoleInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		//���ҽ�ɫ�б������䵽���棬�Ա��û���ѡ��
		PagerModel roles = roleMgr.searchRoles();
		
		request.setAttribute("pm", roles);
		
		return mapping.findForward("user_role_input");
	}
	
	//���û������ɫ��ҳ������Ҫ���ݹ����Ĳ����������û���ʶ����ɫ��ʶ�����ȼ�
	public ActionForward addUserRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		//�û���ʶ
		int userId = uaf.getId();
		//��ɫ��ʶ
		int roleId = uaf.getRoleId();
		//���ȼ�
		int orderNo = uaf.getOrderNo();
		
		userMgr.addOrUpdateUserRole(userId, roleId, orderNo);
		
		return mapping.findForward("pub_add_success");
	}
	
	//ɾ��������û��Ľ�ɫ��ҳ������Ҫ��������Ĳ����������û���ʶ����ɫ��ʶ
	public ActionForward delUserRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		//�û���ʶ
		int userId = uaf.getId();
		//��ɫ��ʶ
		int roleId = uaf.getRoleId();
		
		userMgr.delUserRole(userId, roleId);
		
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward delUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		userMgr.delUser(uaf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	//�򿪽���	
	public ActionForward bindingInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserActionForm uaf = (UserActionForm)form;
		
		request.setAttribute("userId", uaf.getId());
		
		return mapping.findForward("binding_input");
	}
	
	public ActionForward binding(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = userMgr.findUser(uaf.getId());
		
		MailUser mailUser = new MailUser();
		mailUser.setAddress(uaf.getAddress());
		mailUser.setPassword(uaf.getAddrPassword());
		
		user.setMailUser(mailUser);
		
		userMgr.updateUser(user, user.getPerson().getId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public void setPersonMgr(PersonManager personMgr) {
		this.personMgr = personMgr;
	}
	
	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}
	
	public void setRoleMgr(RoleManager roleMgr) {
		this.roleMgr = roleMgr;
	}
}
