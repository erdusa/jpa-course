CREATE TABLE public.person_reference (
	id serial NOT NULL,
	"name" varchar NOT NULL,
	phone varchar NULL,
	pers_id int NOT NULL,
	CONSTRAINT person_reference_pk PRIMARY KEY (id)
);
ALTER TABLE public.person_reference ADD CONSTRAINT pe_re_pe_fk FOREIGN KEY (pers_id) REFERENCES public.person(id);

