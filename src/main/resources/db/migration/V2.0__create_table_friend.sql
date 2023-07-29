CREATE TABLE public.friend (
	pers_id int NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT friend_pk PRIMARY KEY (pers_id,"name")
);

ALTER TABLE public.friend ADD CONSTRAINT fr_pe_fk FOREIGN KEY (pers_id) REFERENCES public.person(id);



