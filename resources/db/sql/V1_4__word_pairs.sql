CREATE TABLE public.word_pairs
(
    id                BIGSERIAL PRIMARY KEY,
    word1       VARCHAR,
    word2   VARCHAR
);

ALTER SEQUENCE word_pairs_id_seq RESTART 1000 INCREMENT BY 50;
ALTER TABLE  public.word_pairs ADD CONSTRAINT wordKey UNIQUE (word1, word2);

