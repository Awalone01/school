 4.0_HW3
select json_build_array(student.name, age, faculty.name) from student, faculty;

select json_build_array(avatar.student_id, cast(1 as bit)) from avatar


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
