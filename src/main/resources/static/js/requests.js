console.log("Requests.js successfully loaded!")

RandomArtistsGET(9);

function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

function RandomArtistsGET(num){
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "http://localhost:8081/artists/random/"+ num);
  xhr.send();
  xhr.responseType = "json";
  xhr.onload = () => {
    if (xhr.readyState == 4 && xhr.status == 200) {
      console.log(xhr.response);
      for (let i = 0; i <num;i++) {
        console.log(xhr.response[i].name + " " + xhr.response[i].paintings);

        //"src="../static/js/requests.js"
        var path_name = xhr.response[i].name.replace(/ /g,"_");
        var path_num = getRandomInt(xhr.response[i].paintings)+1;
        // var path_image_1 = "../static/img/images/"+path_name+"/"+path_name+"_"+path_num+".jpg";
        var path_image = "http://localhost:8081/photo/"+path_name+"/"+path_num;
        console.log(path_image);

        var index= i+1;
        var picture_id = "zoomedImage".concat(index.toString());
        // console.log(picture_id);
        document.getElementById(picture_id).src = path_image;
        // document.getElementById("zoomedImage"+num).src = path_image;
      }
      // const obj = xhr.response[0];

    } else {
      console.log(`Error: ${xhr.status}`);
    }
  };
}


// function RandomArtistsGET(num){

//     const xhr = new XMLHttpRequest();
//     xhr.open("GET", "http://localhost:8081/artists/random/"+num);
//     xhr.send();
//     xhr.responseType = "json";
//     xhr.onload = () => {
//       if (xhr.readyState == 4 && xhr.status == 200) {
//         console.log(xhr.response);
//       } else {
//         console.log(`Error: ${xhr.status}`);
//       }
//     };

// }


// function readTextFile(file){
//     var output ="";
//     var rawFile = new XMLHttpRequest();
//     rawFile.open("GET", file, false);
//     rawFile.onreadystatechange = function (){
//         if(rawFile.readyState === 4){
//             if(rawFile.status === 200 || rawFile.status == 0){
//                 output = rawFile.responseText;
//             }
//         }
//     }
//     rawFile.send(null);
//     console.log(output);
//     return output;
// }
