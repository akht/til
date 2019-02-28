-- PostgreSQLにおいて

-- ilike は大文字小文字を区別しない
-- 以下はすべてtrueになる
select
'ab' ilike 'ab' as "'ab' ilike 'ab'",
'ab' ilike 'Ab' as "'ab' ilike 'Ab'",
'ab' ilike 'aB' as "'ab' ilike 'aB'",
'ab' ilike 'AB' as "'ab' ilike 'AB'",
'Ab' ilike 'ab' as "'Ab' ilike 'ab'",
'Ab' ilike 'Ab' as "'Ab' ilike 'Ab'",
'Ab' ilike 'aB' as "'Ab' ilike 'aB'",
'Ab' ilike 'AB' as "'Ab' ilike 'AB'",
'aB' ilike 'ab' as "'aB' ilike 'ab'",
'aB' ilike 'Ab' as "'aB' ilike 'Ab'",
'aB' ilike 'aB' as "'aB' ilike 'aB'",
'aB' ilike 'AB' as "'aB' ilike 'AB'",
'AB' ilike 'ab' as "'AB' ilike 'ab'",
'AB' ilike 'Ab' as "'AB' ilike 'Ab'",
'AB' ilike 'aB' as "'AB' ilike 'aB'",
'AB' ilike 'AB' as "'AB' ilike 'AB'"


-- like は大文字小文字を区別する
select
'ab' like 'ab' as "'ab' like 'ab'",
'ab' like 'Ab' as "'ab' like 'Ab'",
'ab' like 'aB' as "'ab' like 'aB'",
'ab' like 'AB' as "'ab' like 'AB'",
'Ab' like 'ab' as "'Ab' like 'ab'",
'Ab' like 'Ab' as "'Ab' like 'Ab'",
'Ab' like 'aB' as "'Ab' like 'aB'",
'Ab' like 'AB' as "'Ab' like 'AB'",
'aB' like 'ab' as "'aB' like 'ab'",
'aB' like 'Ab' as "'aB' like 'Ab'",
'aB' like 'aB' as "'aB' like 'aB'",
'aB' like 'AB' as "'aB' like 'AB'",
'AB' like 'ab' as "'AB' like 'ab'",
'AB' like 'Ab' as "'AB' like 'Ab'",
'AB' like 'aB' as "'AB' like 'aB'",
'AB' like 'AB' as "'AB' like 'AB'"

