# Cours9-RoomDB
RoomDB with Dao and repository


Base sure Cours8 avec architecture Activity <-> repository <-> Gestionnaire de donnees 
Cette fois on gere les donnees avec une base de donnees locale grace a library Room

Composants:
- Activity : affiche les donnees ou indique qu'une modification doit leur etre appportee
- Repository : class a qui l'activity indique ce qu'elle souhaite faire avec les donnees et qui se charge de demander a la class qui gere concretement les donnees de l'effectuer
- UserDao : a la place de UserApiService avec annotation permettant d'indiquer les expressions SQL correspondantes au fonctions declarees et ainsi de les executer directement sur la dataBase
- DataBase : a la place du FakeApiService, permet de creer une database locale avec la library room (compose des tables declarees dans l'annotation @Database(entities = Les class pour lequels on souhaites creer des tables)
- Entity : On annote les models que l'on souhaite convertire en Tables avec @Entity 


ressources: slide:  https://docs.google.com/presentation/d/1nxbfVW6fEbdUoGfyjv6QuVtOTlN7Mew2zRYBFpMGO6o/edit?usp=sharing
