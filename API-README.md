# This is the api helper for the websocket part



## Socket
    /socket

###### Kotlin: création
```Java
registry.addEndpoint("/socket").setAllowedOrigins("*").withSockJS()
```
###### TS: connection
```Typescript
let ws = new SockJS("/socket");
this.stompClient = Stomp.over(ws);
let that = this;
this.stompClient.connect({}, "do things")
```

###### Kotlin: création du broker
```Java
registry.enableSimpleBroker("/app/games")
```

## Channels

#### Channel d'user

A chaque fois qu'un joueur rejoint la partie

	/app/games/{id}/users


#### Channel de mots

A chaque fois qu'un joueur à écrit son mot

    /app/games/{gameId}/words
    
    
#### Channel de votes

A chaque fois qu'un joueur à voté

    /app/games/{gameId}/votes
    
    
#### Channel de fin de tour

A chaque fois qu'un joueur est éliminé

    /app/games/{gameId}/turns
    

#### Ajouter un user à une game

	/app/games/{gameId}/users/{userId}

### Code Helps

#### Rejoindre un channel coté client pour recevoir les messages du back

###### TS subscribe:
```Typescript
that.stompClient.subscribe("monChannel", (message) => {"doThingsOnReceive"})
```

#### Envoie d'un message côté serveur aux clients subs au channel

###### Kotlin
```Java
template.convertAndSend("monChannel", message)
```
#### Envoie d'un message côté client vers le serveur

###### TS: 
```Typescript
this.stompClient.send("requestUrl", {}, body);
```
### Recetion d'un message client côté serveur
###### Kotlin:
```
@MessageMapping(“/app/games/{gameId}/users”)
fun maFunction()...
```

