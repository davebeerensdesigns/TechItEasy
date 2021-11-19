

// TODO: Maak in de TelevisionService de functie getTelevisions aan de hand van het voorbeeld in hoofdstuk 6.2 van de cursus Spring Boot cursus in Edhub
// TODO: Doe dit ook voor de getTelevision, saveTelevision, updateTelevision en de deleteTelevision
// TODO: Maak in de TelevisionController een @Autowired om de Service te kunnen gebruiken in de Controller
// TODO: Maak in het project een map aan genaamd Dtos
// TODO: Maak in deze map een klasse aan genaamd TelevisionDto
// TODO: Defenieer in deze klasse alle variabele die een Television object bevat (dezelfde als in het model gedefinieerd staan)
// TODO: Maak daaronder een public static functie aan genaamd fromTelevision. Deze heeft als returnwaarde TelevisionDto en als attribuut Television television
// TODO: Maak in deze functie een var dto = new TelevisionDto();
// TODO: Voeg in de functie voor iedere variable, die je boven deze functie hebt gedeclareerd, een toewijzing naar de dto variable (bijvoorbeeld: dto.name = television.getName(); )
// TODO: Return als laatste stap in deze functie, het dto object en sluit de functie af
// TODO: Maak een klasse aan in de map Dtos genaamd TelevisionInputDto
// TODO: Defenieer ook in deze klasse alle variabelen die een Television object bevat
// TODO: Maak een public functie genaamd toTelevision() met returnwaarde Television
// TODO: Maak in deze functie een var television = new Television();
// TODO: Voeg in de functie voor iedere variable, die je boven deze functie hebt gedeclareerd, een toewijzing naar de television variable (bijvoorbeeld: television.setName(name); )
// TODO: Pas de RequestMappings in de TelevisionController, zodat de controller het verzoek doet aan de servicelaag en het response ook ontvangt van de servicelaag (dit omdat we de Controller eigenlijk zo dom mogelijk willen houden)
// TODO: Pas de servicelaag zo aan dat deze gebruik maakt van de gegevens die de controllerlaag doorgeeft, de Service moet hier dan de logica aan toepassen om met gebruik van de Dtos een returnwaarde terug te kunnen sturen naar de controller