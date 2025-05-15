# Liquibase Rollback Guide

## Overview
This guide explains how to perform rollback operations in Liquibase, which allows you to revert database changes to a previous state.

## Prerequisites
- Liquibase CLI installed
- Proper database credentials configured in `liquibase.properties`
- Database backup (recommended before any rollback operation)

## Rollback Methods

### 1. Rollback to a Tag
```bash
liquibase rollback <tag>
```
Example:
```bash
liquibase rollback v1.0
```

### 2. Rollback Specific Number of Changesets
```bash
liquibase rollbackCount <number>
```
Example:
```bash
liquibase rollbackCount 3
```

### 3. Rollback to a Specific Date
```bash
liquibase rollbackToDate <date>
```
Example:
```bash
liquibase rollbackToDate 2024-05-15
```

### 4. Rollback Single Changeset
```bash
liquibase rollbackOneChangeSet --changeSetId=<id> --changeSetAuthor=<author> --changeSetPath=<path>
```
Example:
```bash
liquibase rollbackOneChangeSet --changeSetId=20250515105522-5 --changeSetAuthor=huyhanhat --changeSetPath=src/main/resources/liquibase/changelog/20250515105522_init_data.mysql.sql
```

## Best Practices

### 1. Always Include Rollback Statements
Add rollback statements to your changesets:

```sql
-- changeset author:id
INSERT INTO table (column) VALUES ('value');

--rollback DELETE FROM table WHERE column = 'value';
```

### 2. Common Rollback Patterns

#### For INSERT statements:
```sql
--rollback DELETE FROM table WHERE [conditions];
```

#### For UPDATE statements:
```sql
--rollback UPDATE table SET column = old_value WHERE [conditions];
```

#### For DELETE statements:
```sql
--rollback INSERT INTO table (columns) VALUES (values);
```

#### For CREATE TABLE statements:
```sql
--rollback DROP TABLE table_name;
```

#### For ALTER TABLE statements:
```sql
--rollback ALTER TABLE table_name [revert changes];
```

## Safety Measures

1. **Always Backup**: Create a database backup before performing rollback operations
2. **Test First**: Test rollback operations in a development environment
3. **Verify Changes**: Review the changes that will be rolled back before executing
4. **Documentation**: Keep track of rollback operations in your deployment documentation

## Troubleshooting

### Common Issues

1. **Missing Rollback Statements**
   - Error: "No rollback support for [operation]"
   - Solution: Add appropriate rollback statements to your changeset

2. **Invalid Tag**
   - Error: "Tag [tag] does not exist"
   - Solution: Verify the tag exists using `liquibase status`

3. **Connection Issues**
   - Error: "Cannot connect to database"
   - Solution: Check database credentials and connection properties

### Useful Commands

- Check current status:
```bash
liquibase status
```

- List all tags:
```bash
liquibase tag
```

- Validate changelog:
```bash
liquibase validate
```

## Additional Resources

- [Liquibase Official Documentation](https://docs.liquibase.com/)
- [Liquibase Rollback Commands](https://docs.liquibase.com/commands/rollback.html)
- [Liquibase Best Practices](https://docs.liquibase.com/best-practices.html)
