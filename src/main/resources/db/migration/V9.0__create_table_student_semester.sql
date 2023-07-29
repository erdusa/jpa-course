CREATE TABLE public.student_semester (
	number_semester int4 NOT NULL,
	stud_id int8 NOT NULL,
	average float4 NOT NULL,
	CONSTRAINT student_semester_pkey PRIMARY KEY (number_semester, stud_id)
);
ALTER TABLE public.student_semester ADD CONSTRAINT fk_stse_stud FOREIGN KEY (stud_id) REFERENCES public.student(id);