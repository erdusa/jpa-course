CREATE TABLE public.person (
	id serial NOT NULL,
	"name" varchar NOT NULL,
	second_name varchar NULL,
	surname varchar NOT NULL,
	created_at timestamp NOT NULL,
	CONSTRAINT person_pk PRIMARY KEY (id)
);

