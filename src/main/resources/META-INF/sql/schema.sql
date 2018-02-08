CREATE TABLE datasources(
  id VARCHAR2(100) NOT NULL PRIMARY KEY,
  name VARCHAR2(50) NOT NULL,
  description VARCHAR2(100) DEFAULT '',
  datasource_id VARCHAR2(100),
  priority NUMERIC
)