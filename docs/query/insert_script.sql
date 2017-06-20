INSERT INTO `auth`.`site_code`
( `site_code`, `site_name` )
VALUES
( 'MCP', 'Mesh Control Platform' );

INSERT INTO `mcp`.`codes`
( `code_no`, `code`, `code_name`, `display_order`, `description`, `creator`, `create_dt` )
VALUES
( 1, 'USER_TYPE', '사용자 유형', 1, '사용자 유형 코드 parent', 'yjhan', now() ),
( 10, 'USER_SEARCH_TYPE', '사용자 조회 타입', 1, '사용자 조회 타입 parent', 'yjhan', now() );

INSERT INTO `mcp`.`codes`
( `parent_code_no`, `code`, `code_name`, `display_order`, `description`, `creator`, `create_dt` )
VALUES
-- ( 1, 'REGULAR', '정직원', 1, '사용자 유형 코드 - 정직원', 'yjhan', now() ),
-- ( 1, 'TEMPORARY', '임시직', 2, '사용자 유형 코드 - 임시직', 'yjhan', now() ),
-- ( 1, 'DISPATCH', '파견직', 3, '사용자 유형 코드 - 파견직', 'yjhan', now() ),
-- ( 1, 'PARTNER', '협력사', 4, '사용자 유형 코드 - 협력사', 'yjhan', now() ),
-- ( 1, 'CUSTOMER', '고객사', 5, '사용자 유형 코드 - 고객사', 'yjhan', now() ),
-- ( 10, 'USER_ID', '통합 ID', 1, '사용자 조회 타입 - 통합 ID', 'yjhan', now() ),
-- ( 10, 'USER_NAME', '사용자 명', 2, '사용자 조회 타입 - 사용자 명', 'yjhan', now() );
( 1, 'GENERAL', '일반', 1, '사용자 유형 코드 - 일반', 'yjhan', now() );

INSERT INTO `mcp`.`codes`
( `code_no`, `code`, `code_name`, `display_order`, `description`, `creator`, `create_dt` )
VALUES
( 50, 'GROUP_SEARCH_TYPE', '그룹 조회 타입', 1, '그룹 조회 타입 parent', 'yjhan', now() );

INSERT INTO `mcp`.`codes`
( `parent_code_no`, `code`, `code_name`, `display_order`, `description`, `creator`, `create_dt` )
VALUES
( 50, 'GROUP_NAME', '권한 그룹명', 1, '그룹 조회 타입 - 권한 그룹명', 'yjhan', now() ),
( 50, 'GROUP_CODE', '권한 그룹 코드', 2, '그룹 조회 타입 - 권한 그룹 코드', 'yjhan', now() );

INSERT INTO `mcp`.`codes`
( `code_no`, `code`, `code_name`, `display_order`, `description`, `creator`, `create_dt` )
VALUES
( 71, 'GROUP_TYPE', '그룹 타입', 1, '그룹 타입 parent', 'yjhan', now() );

INSERT INTO `mcp`.`codes`
( `parent_code_no`, `code`, `code_name`, `display_order`, `description`, `creator`, `create_dt` )
VALUES
( 71, 'GENERAL', '일반', 1, '그룹 타입 - 일반', 'yjhan', now() );

INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,11,'권한 관리|계정 관리|목록','목록','/auth/accounts');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,12,'권한 관리|계정 관리|등록','등록','/auth/accounts/register');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,13,'권한 관리|계정 관리|수정','수정','/auth/accounts/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,21,'권한 관리|계정 관리|목록','목록','/auth/groups');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,22,'권한 관리|계정 관리|등록','등록','/auth/groups/register');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,23,'권한 관리|계정 관리|수정','수정','/auth/groups/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,31,'배송비 관리|요금 분배 관리|목록','목록','/fee/distribution');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,32,'배송비 관리|요금 분배 관리|등록','등록','/fee/distribution/register');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,33,'배송비 관리|요금 분배 관리|수정','수정','/fee/distribution/modify/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,41,'배송비 관리|거리별 요금 관리|목록','목록','/fee/distance');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,42,'배송비 관리|거리별 요금 관리|등록','등록','/fee/distance/register');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,43,'배송비 관리|거리별 요금 관리|수정','수정','/fee/distance/modify/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,51,'배송비 관리|할증 관리|목록','목록','/fee/extra');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,52,'배송비 관리|할증 관리|등록','등록','/fee/extra/register');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,53,'배송비 관리|할증 관리|수정','수정','/fee/extra/modify/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,61,'업체 관리|파트너 관리|목록','목록','/business/partner/list');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,62,'업체 관리|파트너 관리|등록','등록','/business/partner/form/create');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,63,'업체 관리|파트너 관리|수정','수정','/business/partner/form/edit/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,71,'업체 관리|오퍼레이터 관리|목록','목록','/business/operator/list');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,72,'업체 관리|오퍼레이터 관리|등록','등록','/business/operator/form/create');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,73,'업체 관리|오퍼레이터 관리|수정','수정','/business/operator/form/edit/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,81,'업체 관리|기사 관리|목록','목록','/business/agent/list');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,82,'업체 관리|기사 관리|등록','등록','/business/agent/form/create');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,83,'업체 관리|기사 관리|수정','수정','/business/agent/form/edit/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,91,'업체 관리|본사 관리|목록','목록','/business/client');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,92,'업체 관리|본사 관리|등록','등록','/business/client/register');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,93,'업체 관리|본사 관리|수정','수정','/business/client/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,101,'업체 관리|상점 관리|목록','목록','/business/client');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,102,'업체 관리|상점 관리|등록','등록','/business/client/register');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,103,'업체 관리|상점 관리|수정','수정','/business/client/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,111,'관제 관리|관제 현황|목록','목록','/monitoring/live');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,112,'관제 관리|관제 현황|상세','상세','/monitoring/form/{id}');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,121,'관제 관리|상담이력 관리|목록','목록','');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,122,'관제 관리|상담이력 관리|등록','등록','');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,123,'관제 관리|상담이력 관리|수정','수정','');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,131,'관제 관리|문자 관리|목록','목록','');
INSERT INTO `auth`.`authority` ( `site_code_no`,`display_order`,`authority_name`,`view_name`,`view_uri` ) VALUES (1,132,'관제 관리|문자 관리|발송','발송','');
