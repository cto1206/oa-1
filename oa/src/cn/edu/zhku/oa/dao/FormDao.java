package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.model.FieldInput;
import cn.edu.zhku.oa.model.FieldType;
import cn.edu.zhku.oa.model.FlowForm;
import cn.edu.zhku.oa.model.FormField;

/**
 * ��������
 * @author Lee
 *
 */
public interface FormDao {
	
	//��
	public void addForm(FlowForm form);
	public void delForm(int formId);
	public FlowForm findForm(int workflowId);
	public List searchAllForms();
	
	//����
	public void addField(FormField field);
	public void delField(int fieldId);
	public FormField findFormField(int fieldId);
	public List searchAllFields(int formId);

	//��������
	public FieldType findFieldType(int typeId);
	public List searchFieldTypes();
	
	//���������
	public FieldInput findFieldInput(int inputId);
	public List searchFieldInputs();
	
	public void updateFieldItems(FormField field);
}
