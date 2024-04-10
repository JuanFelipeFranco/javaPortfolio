
/*Optional
La clase Optional permite encapsular un dato del cual no se tiene certeza de su valor,
evitando la utilización de valores null, excepciones NullPointerException y la repetición
de verificaciones de tipo dato != null. ⠀ Esta clase además provee métodos que pueden ser
usados para manejar el dato dentro del Optional, o para contemplar los casos cuando el
dato no está presente. Dependiendo del caso estos métodos pueden recibir un Function,
Consumer, Supplier, etc. ⠀ Por ejemplo, la función getPersona carga desde la base de
datos una Persona y la devuelve dentro de un Optional<Persona>.

public Optional<Persona> getPersona(int id) {
    Persona p = database.get(id);
    if (p == null) {
        return Optional.empty();
    } else {
        return Optional.of(p);
    }
// También podría retornarse Optional.ofNullable(p);*/

