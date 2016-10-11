
window.onload = init;
var rutaContacto = "http://localhost:8080/CRUDrest/rest/";


function addSocio(nombre, telefono) {
    var nuevoSocio = {"socio": {
            "nombre": nombre,
            "telefono": telefono
        }};
    $.ajax({
        type: "POST",
        url: rutaContacto + "socios",
        data: JSON.stringify(nuevoSocio),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            imprimirSocio(response.socio);
        },
        error: function () {
            alert("Error");
        }
    });

}

function removeSocio(element) {
    var id = element;
        $.ajax({
        type: "DELETE",
        url: rutaContacto + "socios/"+ id,
        success: function (response) {
            document.getElementById(id).remove();
        },
        error: function () {
            alert("Error");
        }
    });
}

function imprimirSocio(socio) {
    var content = document.getElementById("content");

    var socioDiv = document.createElement("div");
    socioDiv.setAttribute("id", socio.id);
    socioDiv.setAttribute("class", "socio Electronics");
    //socioDiv.setAttribute("class", "Electronics");
    content.appendChild(socioDiv);

    var socioName = document.createElement("span");
    socioName.setAttribute("class", "socioName");
    socioName.innerHTML = socio.nombre;
    socioDiv.appendChild(socioName);

    var socioType = document.createElement("span");
    socioType.innerHTML = "<b>Tel:</b> " + socio.telefono;
    socioDiv.appendChild(socioType);

//    var socioStatus = document.createElement("span");
//    if (socio.status === "On") {
//        socioStatus.innerHTML = "<b>Status:</b> " + socio.status + " (<a href=\"#\" OnClick=toggleDevice(" + socio.id + ")>Turn off</a>)";
//    } else if (socio.status === "Off") {
//        socioStatus.innerHTML = "<b>Status:</b> " + socio.status + " (<a href=\"#\" OnClick=toggleDevice(" + socio.id + ")>Turn on</a>)";
//        //socioDiv.setAttribute("class", "socio off");
//    }
//    socioDiv.appendChild(socioStatus);
//
//    var socioDescription = document.createElement("span");
//    socioDescription.innerHTML = "<b>Comments:</b> " + socio.description;
//    socioDiv.appendChild(socioDescription);

    var removeSocio = document.createElement("span");
    removeSocio.setAttribute("class", "removeSocio");
    removeSocio.innerHTML = "<a href=\"#\" OnClick=removeSocio(" + socio.id + ")>Remove socio</a>";
    socioDiv.appendChild(removeSocio);
}

function showForm() {
    document.getElementById("addDeviceForm").style.display = '';
}

function hideForm() {
    document.getElementById("addDeviceForm").style.display = "none";
}

function formSubmit() {
    var form = document.getElementById("addDeviceForm");
    var nombre = form.elements["s_name"].value;
    var telefono = form.elements["s_tel"].value;
    hideForm();
    document.getElementById("addDeviceForm").reset();
    addSocio(nombre, telefono);
}

function cargarTodosSocios() {
    $.ajax({
        type: "GET",
        url: rutaContacto + "socios",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {

            $.each(response, function (i, obj) {
                //use obj.id and obj.name here, for example:
                //console.log(obj.socio);
                imprimirSocio(obj.socio);
            });
        },
        error: function () {
            alert("Error");
        }
    });
}

function init() {
    hideForm();
    cargarTodosSocios();
}
