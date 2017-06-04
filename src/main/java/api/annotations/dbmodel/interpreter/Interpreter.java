package api.annotations.dbmodel.interpreter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import api.annotations.dbmodel.Column;
import api.annotations.dbmodel.DbIgnore;
import api.annotations.dbmodel.Id;
import api.annotations.dbmodel.Table;
import api.util.AfStringUtil;

/**
 * db.annotation 解释器
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
public class Interpreter {
	
	/**
	 * 获取field是否是数据库列
	 * @param field
	 * @return
	 */
	public static boolean isColumn(Field field) {
		int modify = field.getModifiers();
		return !Modifier.isFinal(modify) && !Modifier.isStatic(modify) 
				&& !Modifier.isTransient(modify) 
				&& !field.isAnnotationPresent(DbIgnore.class);
	}
	/**
	 * 获取field的列名称
	 * @param field
	 * @return
	 */
	public static String getColumnName(Field field) {
		if (field.isAnnotationPresent(Column.class)) {
			Column column = field.getAnnotation(Column.class);
			if (AfStringUtil.isNotEmpty(column.value())) {
				return column.value();
			}
		}
		if (field.isAnnotationPresent(Id.class)) {
			Id id = field.getAnnotation(Id.class);
			if (AfStringUtil.isNotEmpty(id.value())) {
				return id.value();
			}
		}
		return field.getName();
	}
	/**
	 * 获取clazz数据表名称
	 * @param clazz
	 * @return
	 */
	public static String getTableName(Class<?> clazz) {
		if (clazz.isAnnotationPresent(Table.class)) {
			Table table = clazz.getAnnotation(Table.class);
			if (table.value() != null && table.value().length() > 0) {
				return table.value();
			}
		}
		return clazz.getSimpleName();
	}
	/**
	 * 获取clazz的主键ID名称
	 * @param clazz
	 * @return
	 */
	public static String getIdName(Class<?> clazz) {
		Field field = getIdField(clazz);
		if (field != null) {
			Id id = field.getAnnotation(Id.class);
			if (id == null || id.value().trim().length() == 0) {
				return field.getName();
			}
			return id.value();
		}
		return "ID";
	}

	/**
	 * 获取clazz的主键ID名称
	 * @param clazz
	 * @return
	 */
	public static Field getIdField(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();
		while (!clazz.equals(Object.class)) {
			for (Field field : clazz.getDeclaredFields()) {
				fields.add(field);
			}
			clazz = clazz.getSuperclass();
		}
		List<Field> cloumns = new ArrayList<Field>();
		for (Field field : fields) {
			if (isColumn(field)) {
				if (isPrimaryKey(field)) {
					return field;
				}
				cloumns.add(field);
			}
		}
		for (Field field : cloumns) {
			String name = field.getName().toLowerCase(Locale.ENGLISH);
			if (name.endsWith("id")) {
				return field;
			}
		}
		return null;
	}

	/**
	 * 判断 Field 是否为 ID字段
	 * @param field
	 * @return
	 */
	public static boolean isPrimaryKey(Field field) {
		return field.isAnnotationPresent(Id.class)
				|| (field.isAnnotationPresent(Column.class)
				&& field.getAnnotation(Column.class).id());
	}

}
