SELECT student.name, student.age, faculty.name
FROM student
INNER JOIN faculty ON student.faculty_id = faculty.id;

select  student.name, avatar.file_path
from student
right join avatar on avatar.student_id = student.id;

-- Показать, что список не из 7 студентов
select  student.name, avatar.file_path
from student
left join avatar on avatar.student_id = student.id;
master
