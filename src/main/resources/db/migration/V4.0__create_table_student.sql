CREATE TABLE public.student (
	id serial NOT NULL,
	pers_id int NOT NULL,
	code varchar NOT NULL,
	CONSTRAINT student_pk PRIMARY KEY (Id)
);

ALTER TABLE public.student ADD CONSTRAINT es_pe_fk FOREIGN KEY (pers_id) REFERENCES public.person(id);
