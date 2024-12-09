// Declaración de dos arreglos para almacenar tareas y cursos.
var tasks=[];
var COURSES=[];

// Función para mostrar las tareas en la página.
function showTasks(){
    // Obtiene el elemento con el ID "row" y lo vacía.
document.getElementById("row").innerHTML="";
const row = document.getElementById("row");

// Itera a través de las tareas y crea elementos HTML para mostrar cada tarea.
tasks.forEach((task, index) => {
    const divRow = document.createElement("div");
// Configura las propiedades de estilo del div.
    divRow.setAttribute("class", "col-1 col-sm-6");
    divRow.setAttribute(
      "style",
      "background:#3498db; margin:5px; width:355px"
    );

    // Crea elementos para mostrar información de la tarea.
    // Establece el contenido y el estilo de cada elemento.
    const asig = document.createElement("h1");
    asig.append(document.createTextNode(task.idActividad));
    asig.setAttribute("style", "color:white;,", "font-family: calibri;")
    divRow.append(asig);

     const cod = document.createElement("h4");
     cod.textContent= "Codigo de la Asignatura:";
     cod.setAttribute("style", "color:##388a30;")
     divRow.appendChild(cod);

    const codi = document.createElement("h1");
    codi.append(document.createTextNode(task.idMateria));
    codi.setAttribute("style", "color:white;,", "font-family: calibri;")
    divRow.append(codi);


    const tip = document.createElement("h4");
    tip.textContent= "Tipo de Actividad:";
    tip.setAttribute("style", "color:##388a30;")
    divRow.appendChild(tip);


    const tip2 = document.createElement("h5");
    tip2.append(document.createTextNode(task.tipoActividad));
    tip2.setAttribute("style", "color:white;")
    divRow.append(tip2);

    const act = document.createElement("h4");
    act.textContent= "Nombre:";
    act.setAttribute("style", "color:##388a30;")
    divRow.appendChild(act);

    const acti = document.createElement("h5");
    acti.append(document.createTextNode(task.descripcionActividad));
    acti.setAttribute("style", "color:white;")
    divRow.append(acti);

    const pond = document.createElement("h4");
    pond.textContent="Porcentaje:";
    pond.setAttribute("style", "color:#388a30;")
    divRow.appendChild(pond);

    const ponde = document.createElement("h5");
    ponde.append(document.createTextNode(task.ponderado));
    ponde.setAttribute("style", "color:white;")
    divRow.append(ponde);

    const fec = document.createElement("h4");
    fec.textContent= "Fecha de entrega:";
    fec.setAttribute("style", "color:##388a30;")
    divRow.appendChild(fec);

    const fech = document.createElement("h5");
    fech.append(document.createTextNode(task.fechaEntrega));
    fech.setAttribute("style", "color:white;")
    fech.setAttribute("id", "fech");
    divRow.append(fech);

    const not = document.createElement("h4");
    not.textContent= "Nota:";
    not.setAttribute("style", "color:#5B5B5B;")
    divRow.appendChild(not);

    const input = document.createElement("input");
    input.setAttribute("class", "form-control");
    input.setAttribute("class", "col-md-2");
    input.setAttribute("id", "nota"+task.idActividad);
    input.value=document.createTextNode(task.calificacionActividad).textContent
    divRow.append(input);

    const p = document.createElement("p");
    divRow.appendChild(p);

    const pend = document.createElement("h4");
    pend.textContent= "Pendiente";
    pend.setAttribute("style", "color:#D65757;")
    pend.setAttribute("id", "pendi"+task.idActividad);
    divRow.appendChild(pend);
    if (task.calificacionActividad!=0){
        input.disabled=true;
        pend.innerHTML="Finalizada"
        pend.style.color="#ffffff";
    }

    const p2 = document.createElement("p");
    divRow.appendChild(p2);

    const button2 = document.createElement("button2");
    button2.setAttribute("class", "btn btn-success w-50");
    button2.setAttribute("onclick",`agregar(${task.idActividad})`);

    button2.append(document.createTextNode("Agregar nota"));

    divRow.append(button2);

    const br = document.createElement("br");
    divRow.appendChild(br);

    const button = document.createElement("button");
    button.setAttribute("class", "btn btn-danger");
    button.setAttribute("onclick", `delTask(${task.idActividad})`);
    button.append(document.createTextNode("Eliminar Tarea"));

    divRow.append(button);

    // Añade los elementos creados al divRow.
    // Finalmente, agrega divRow al elemento con el ID "row".
    document.getElementById("row").append(divRow);
  });
}
// Configura un event listener para el botón "btnActivity" (Agregar actividad).
document.getElementById("btnActivity").addEventListener("click", () => {

    const ObAsignatura = document.getElementById("ObAsignatura").value;
    const actividad = document.getElementById("actividad").value;
    const tipo = document.getElementById("tipo").value;
    const ponderado = document.getElementById("ponderado").value;
    const fecha = document.getElementById("fecha").value;
    // Realiza validaciones de los campos del formulario.

    // Si todas las validaciones pasan, crea una nueva tarea y la agrega al arreglo "tasks".
    // También realiza una solicitud XMLHttpRequest para almacenar la tarea en el servidor.

    if(ObAsignatura==0 || ObAsignatura==""){
      alert("No ha seleccionado la Asignatura");
     }
     else if(actividad.length==0 || /^\$+$/.test(actividad)){
      alert("El campo de actividad esta vacio");
   } else if(tipo==0 || tipo==""){
      alert("No ha seleccionado el tipo");
    }
    else if(ponderado.length==0|| /^\$+$/.test(ponderado)||isNaN(ponderado)){
      alert("No ha seleccionado el ponderado");
    }
    else if(fecha.length==0){
      alert("No ha seleccionado una fecha");
    }
    else{
      var materias=  document.getElementById('ObAsignatura')

        var idMateria=COURSES[ materias.selectedIndex].id

    tasks.push({ id: tasks.length,tipo:tipo, descripcion:actividad,pon:ponderado,fecha:fecha, nota:0 ,idMateria:idMateria});

    document.getElementById("ObAsignatura").value = "";
    document.getElementById("actividad").value = "";
    document.getElementById("tipo").value = "";
    document.getElementById("ponderado").value = "";
    document.getElementById("fecha").value = "";

        const xhr = new XMLHttpRequest()
        xhr.open("POST","ServletActivity",true)

        xhr.onreadystatechange = ()=>{
            if( xhr.readyState === 4 && xhr.status === 200 ){
                const resp = JSON.parse( xhr.responseText)
                if(resp.state){
                    alert("Acividad agreagada")
                }else{
                    alert("No se ha agreagado")
                }
            }
        }

        const data = `id=${tasks.length}&tipo=${tipo}&descripcion=${actividad}&ponderado=${ponderado}&fecha=${fecha}&calificacion=${0}&idMateria=${idMateria}&add=${true}`;
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send( data )
        // Recarga la página para actualizar la vista.
        location.reload();
    }
  });

// Función para agregar una calificación a una tarea.
function agregar(id){
    // Obtiene la nota ingresada por el usuario.
  const nota = document.getElementById("nota"+id).value;
// Realiza validaciones de la nota ingresada.

    // Si la validación pasa, actualiza la nota de la tarea en el arreglo "tasks".
    // También realiza una solicitud XMLHttpRequest para almacenar la calificación en el servidor.

if(nota.length==0|| /^\$+$/.test(nota)||isNaN(nota)){
  alert("La nota no es valida");
 }else{
  alert("La nota es "+nota);


    const xhr = new XMLHttpRequest()
    xhr.open("POST","ServletActivity",true)

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            const resp = JSON.parse( xhr.responseText)
            if(resp.state){
                alert("Acividad agreagada")
            }else{
                alert("No se ha agreagado")
            }
        }
    }

    const data = `id=${id}&calificacion=${nota}&add=${false}&upDate=${true}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhr.send( data )

    document.getElementById("nota"+id).disabled=true;
    document.getElementById("pendi"+id).innerHTML="Finalizada"
    const pend = document.getElementById("pendi"+id)
    pend.style.color="#9ED655";

}
    // Deshabilita el campo de nota y muestra "Finalizada" si la tarea ya tiene una calificación.
    // Recarga la página para actualizar la vista.
    location.reload();
}

// Función para eliminar una tarea.
  function delTask(id) {
      // Realiza una solicitud XMLHttpRequest para eliminar la tarea del servidor.
      const xhr = new XMLHttpRequest()
      xhr.open("POST","ServletActivity",true)

      xhr.onreadystatechange = ()=>{
          if( xhr.readyState === 4 && xhr.status === 200 ){
              const resp = JSON.parse( xhr.responseText)
              if(resp.state){
                  alert("Eliminado")
              }else{
                  alert("No se ha eliminado")
              }
          }
      }
      const data = `id=${id}&add=${false}`;
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xhr.send( data )
      // Recarga la página para actualizar la vista.
      location.reload();
      showTasks();
  }
// Configura un event listener para el botón "btnCourse" (Agregar materia).
document.getElementById("btnCourse").addEventListener("click", () => {
// Obtiene los valores de los campos del formulario.
    const codigo = document.getElementById("codigo").value;
    const asignatura = document.getElementById("asignatura").value;
    // Si todas las validaciones pasan, crea una nueva materia y la agrega al arreglo "COURSES".

    if(codigo.length==0|| /^\$+$/.test(codigo)||isNaN(codigo)){
        alert("El codigo no es valido");
    }else if(asignatura.length==0|| /^\$+$/.test(asignatura)){
        alert("No se ha ingresado el nombre de la Asignatura");
    }
    const xhr = new XMLHttpRequest()
    xhr.open("POST","ServletCourse",true)

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            const resp = JSON.parse( xhr.responseText)
            if(resp.state){
                alert("Materia agregada")
            }else{
                alert("No se ha agregado la materia")
            }
        }
    }
// También realiza una solicitud XMLHttpRequest para almacenar la materia en el servidor.
    const data = `id=${codigo}&nombre=${asignatura}&nota=${0}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send( data )
// Recarga la página para actualizar la vista.
    location.reload();
});


// Función que se llama al cargar la página.
function  load(){
    // Llama a otras funciones para cargar información de cursos y actividades.
    loadCourse();
    loadActivity();
    loadActivitiesName();
}
// Función para cargar el nombre de las actividades.
function loadActivitiesName(){
    // Realiza una solicitud XMLHttpRequest para obtener información de cursos y calcular el promedio.
    const xhr = new XMLHttpRequest()
    xhr.open("GET",`ServletCourse`,true)
    xhr.onreadystatechange = ()=>{
        if( xhr.status === 200 && xhr.readyState === 4){

            const courses = JSON.parse( xhr.responseText)
            COURSES=courses
            var promedio=0

            var tabla   = document.createElement("table")

            courses.forEach( course => {

                const tableRow = document.createElement("tr")

                const col =document.createElement('td')
                col.append(document.createTextNode(course.name))

                const rate =document.createElement('td')
                rate.append(document.createTextNode(course.rate))
                promedio=promedio+parseInt(course.rate)
                tableRow.appendChild(col)
                tableRow.appendChild(rate)

                document.getElementById("tBody").appendChild(tableRow)

            })
            document.getElementById("tBody").appendChild(tabla);


            promedio=promedio/COURSES.length

            document.getElementById("row2").innerHTML="Promedio Semestre: "+promedio;
        }
    }
    // Actualiza la vista con la información obtenida.
    xhr.send(null)
}

// Función para cargar la información de los cursos.
function loadCourse(){
    // Realiza una solicitud XMLHttpRequest para obtener información de cursos.
    const xhr = new XMLHttpRequest()
    xhr.open("GET",`ServletCourse`,true)
    xhr.onreadystatechange = ()=>{
        if( xhr.status === 200 && xhr.readyState === 4){

            const courses = JSON.parse( xhr.responseText)
            COURSES=courses
            courses.forEach( course => {
                const option =document.createElement('option')
                option.value=course.name
                option.text=course.id+"-"+course.name
                document.getElementById('ObAsignatura').appendChild(option)
            })
        }
    }
    // Actualiza la vista con la información obtenida.
    xhr.send(null)
}
// Función para cargar la información de las actividades.
function loadActivity(){
    const xhr = new XMLHttpRequest()
    xhr.open("GET",`ServletActivity`,true)
    xhr.onreadystatechange = ()=>{
        if( xhr.status === 200 && xhr.readyState === 4){
            const courses = JSON.parse( xhr.responseText)
            tasks=courses
            showTasks()
        }
    }
    xhr.send(null)
    // Actualiza la vista con la información obtenida llamando a la función "showTasks()".
}


