/*
 *修改下列字段为binary,实现区分大小写的功能
 *2017-11-28
 */

/*分组管理-->新建分组*/
alter table wzt_customized_group MODIFY COLUMN group_name varchar(45) binary not null ;

/*权限管理-->新增管理员*/
alter table wzt_account MODIFY COLUMN username varchar(40) binary not null ;

/*分组管理-->新建分组*/
alter table wzy_account_gj MODIFY COLUMN account_name varchar(40) binary not null ;

/*内容监测-->检测账号-->分组管理-->新建分组*/
alter table wzy_monitor_gzh_group MODIFY COLUMN `name` varchar(100) binary not null ;

/*权限管理-->新增角色*/
alter table wzt_role MODIFY COLUMN role_name varchar(100) binary ;

/*素材管理-->标签管理-->新建标签*/
alter table wzy_content_tag MODIFY COLUMN tag_name varchar(100) binary ;

/*权限管理-->新增审核人员*/
alter table wzy_account_audit MODIFY COLUMN auditor_account_name varchar(40) binary not null ;