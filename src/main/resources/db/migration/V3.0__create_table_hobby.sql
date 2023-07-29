CREATE TABLE public.hobby (
	pers_id int NOT NULL,
	"name" varchar NOT NULL,
	"position" int2 NOT NULL,
	CONSTRAINT hobby_pk PRIMARY KEY (pers_id,"name")
);

ALTER TABLE public.hobby ADD CONSTRAINT ho_pe_fk FOREIGN KEY (pers_id) REFERENCES public.person(id);



