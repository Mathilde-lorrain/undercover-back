CREATE TABLE public.game
(
  id        BIGSERIAL PRIMARY KEY,
  status    VARCHAR NOT NULL
);

CREATE TABLE public.player
(
  id          BIGSERIAL PRIMARY KEY,
  name        VARCHAR UNIQUE NOT NULL
);

CREATE TABLE public.role
(
    id BIGSERIAL PRIMARY KEY,
    player_id   BIGINT NOT NULL REFERENCES player(id),
    game_id     BIGINT NOT NULL REFERENCES game(id),
    role_type   VARCHAR NOT NULL,
    alive       BOOLEAN
);

CREATE TABLE public.turn
(
  id                BIGSERIAL   PRIMARY KEY,
  game_id           BIGINT      NOT NULL REFERENCES game (id),
  killed_player_id  BIGINT      NULL REFERENCES player (id)
);

CREATE TABLE public.vote
(
    id          BIGINT PRIMARY KEY,
    turn_id     BIGINT NOT NULL REFERENCES turn(id),
    player_id   BIGINT NOT NULL REFERENCES player(id),
    target_id   BIGINT NOT NULL REFERENCES player(id)
);

CREATE TABLE public.word
(
    id          BIGINT PRIMARY KEY,
    turn_id     BIGINT NOT NULL REFERENCES turn(id),
    player_id   BIGINT NOT NULL REFERENCES player(id),
    word        VARCHAR NOT NULL
);