USE alunos;

SELECT *FROM alunos.aluno;
SELECT *FROM alunos.historico;
SELECT *FROM alunos.aluno_historico;

SELECT * FROM historico WHERE aluno_id = 102;

SELECT * FROM alunos.aluno WHERE nome LIKE '%Nome%';

SELECT * FROM historico;

SELECT
    h.id AS historico_id,
    h.data_registro,
    h.peso
FROM 
    aluno a
JOIN 
    aluno_historico ah ON a.id = ah.aluno_id
JOIN 
    historico h ON ah.historico_id = h.id
WHERE 
    a.id = 10
ORDER BY 
    h.data_registro;
    
DELETE FROM alunos.aluno_historico WHERE aluno_id = 20