-- PostgreSQL
-- 任意の型を持つカラムを検索

select
    table_schema,
    table_name,
    column_name,
    data_type
from
    information_schema.columns
where
    table_catalog='hoge'
    and
    table_name in ('table')
    and
    data_type in ('double precision','real')
order by
    table_name, ordinal_position;
