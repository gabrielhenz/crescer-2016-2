//exercicio 7 - mesclar
function mesclar(obj1, obj2, bool) {
    if (bool) {
        propriedadesObj1 = Object.getOwnPropertyNames(obj1);
        propriedadesObj2 = Object.getOwnPropertyNames(obj2);
        for (var i = 0; i < propriedadesObj1.length; i++) {
            for (var j = 0; j < propriedadesObj2.length; j++) {
                if (obj1[propriedadesObj1[i]] instanceof Object && obj2[propriedadesObj2[j]]) {
                    Object.assign(obj1[propriedadesObj1[i]], obj2[propriedadesObj1[j]]);
                }
            }
        }
        Object.assign(obj1, obj2);
    }
}