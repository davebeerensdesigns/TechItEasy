

// TODO: Om deze kolom ook te vullen zal je in servicelaag ook een functie moeten maken die een koppeling maakt tussen de Television en de RemoteController. Dit doe je in de TelevisionService

// TODO: Voeg de functie "assignRemoteControllerToTelevision" toe in de TelevisionService. Zoals je ziet herkent de TelevisionService de RemoteControllerRepository niet, dit komt omdat we deze nog niet gekoppeld hebben met een @Autowired, gelukkig hoef je niet alles opnieuw te doen. Je kan bovenaan in de TelevisionService onder de private TelevisionRepository een private RemoteControllerRepository declareren. En dan in de bestaande @Autowired deze toevoegen op dezelfde manier als de TelevisionRepository. Dit resulteerd in: @Autowired public TelevisionService (TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository) { this.televisionRepository = televisionRepository; this.remoteControllerRepository = remoteControllerRepository;}

// TODO: Om deze functie uit te kunnen voeren moet je in de TelevisionController een PutRequest maken met endpoint "/televisions/{id}/remotecontroller" om aan te spreken. Voeg deze toe en geef de televisionId mee als @PathVariable en de remoteControllerId als @RequestBody doormiddel van een IdInputDto input.

// TODO: Hiervoor missen je nog de IdInputDto. Maak in het mapje Dtos een nieuwe klasse aan voor de IdInputDto. Declareer in deze dto een public Long id toe, meer hoeft er niet in

// TODO: Gefeliciteerd, je hebt zo juist de eerste relatie gelegd in je applicatie.

// TODO: Alleen als je nu met een get alle Televisions ophaalt zien je geen RemoteController. Dit komt omdat we in de TelevisionDto nog niks hebben verteld over de RemoteController.De makkelijkste manier om hier de connectie te leggen is de public RemoteControllerDto remoteController; toe te voegen aan de variable van de TelevisionDto

// TODO: Test alle functies voor je applicatie zover met postman.