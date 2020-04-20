
CREATE TABLE public.game
(
  id                BIGSERIAL PRIMARY KEY,
  status            VARCHAR NOT NULL,
  civil_word        VARCHAR,
  undercover_word   VARCHAR
);

CREATE TABLE public.users
(
  id          BIGSERIAL PRIMARY KEY,
  name        VARCHAR UNIQUE NOT NULL,
  password    VARCHAR NOT NULL
);

CREATE TABLE public.role
(
    id          BIGSERIAL   PRIMARY KEY,
    user_id     BIGINT      NOT NULL REFERENCES users(id),
    game_id     BIGINT      NOT NULL REFERENCES game(id),
    role_type   VARCHAR     NOT NULL,
    alive       BOOLEAN,
    has_won       BOOLEAN
);

CREATE TABLE public.turn
(
  id                BIGSERIAL   PRIMARY KEY,
  game_id           BIGINT      NOT NULL REFERENCES game(id),
  turn_number       INT         NOT NULL,
  killed_player_id  BIGINT      NULL REFERENCES role(id)
);

CREATE TABLE public.vote
(
    id          BIGINT PRIMARY KEY,
    turn_id     BIGINT NOT NULL REFERENCES turn(id),
    voter_id    BIGINT NOT NULL REFERENCES role(id),
    target_id   BIGINT NOT NULL REFERENCES role(id)
);

CREATE TABLE public.word
(
    id          BIGINT PRIMARY KEY,
    turn_id     BIGINT NOT NULL REFERENCES turn(id),
    role_id     BIGINT NOT NULL REFERENCES role(id),
    word        VARCHAR NOT NULL
);

ALTER SEQUENCE game_id_seq INCREMENT BY 50;
ALTER SEQUENCE turn_id_seq INCREMENT BY 50;
ALTER SEQUENCE users_id_seq INCREMENT BY 50;
ALTER SEQUENCE role_id_seq INCREMENT BY 50;
