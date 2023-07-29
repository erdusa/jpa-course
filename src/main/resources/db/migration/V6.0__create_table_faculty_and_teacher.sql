CREATE TABLE public.faculty (
	id serial NOT NULL,
	code varchar NOT NULL,
    "name" varchar NOT NULL,
	CONSTRAINT faculty_pk PRIMARY KEY (id)
);

CREATE TABLE public.teacher (
	pers_id int NOT NULL,
	facu_id int NOT NULL,
	CONSTRAINT teacher_pk PRIMARY KEY (pers_id, facu_id)
);

ALTER TABLE public.teacher ADD CONSTRAINT te_pe_fk FOREIGN KEY (pers_id) REFERENCES public.person(id);
ALTER TABLE public.teacher ADD CONSTRAINT te_fa_fk FOREIGN KEY (facu_id) REFERENCES public.faculty(id);

