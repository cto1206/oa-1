package cn.edu.zhku.oa.manager;

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
public interface FormManager {
	
	//��
	public void addForm(FlowForm form,int workflowId);
	public void delForm(int formId);
	public FlowForm findForm(int workflowId);
	public List searchAllForms();
	
	//����
	public void addField(FormField field,int formId,int fieldTypeId,int fieldInputId);
	public void delField(int fieldId);
	public FormField findFormField(int fieldId);
	public List searchAllFields(int formId);

	//��������
	public FieldType findFieldType(int typeId);
	public List searchFieldTypes();
	
	//���������
	public FieldInput findFieldInput(int inputId);
	public List searchFieldInputs();
	
	public void updateFieldItems(int fieldId,List items);
}
