CREATE TABLE public.subject (
	id serial NOT NULL,
	code varchar NOT NULL,
    "name" varchar NOT NULL,
	CONSTRAINT subject_pk PRIMARY KEY (id)
);

CREATE TABLE public.subject_student (
	stud_id int NOT NULL,
	subj_id int NOT NULL,
	CONSTRAINT subject_student_pk PRIMARY KEY (stud_id, subj_id)
);

ALTER TABLE public.subject_student ADD CONSTRAINT su_es_es_fk FOREIGN KEY (stud_id) REFERENCES public.student(id);
ALTER TABLE public.subject_student ADD CONSTRAINT su_es_su_fk FOREIGN KEY (subj_id) REFERENCES public.subject(id);

