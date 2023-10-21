import events from '../data/events.json' assert { type: 'json' };


const canvas = document.getElementById("myCanvas");
const ctx = canvas.getContext("2d");
const groupedData = groupData(events);
const applyFilterButton = document.getElementById("applyFilter");

// Set the coordinates of Ukraine
const UKRAINE_RECT = {
  top: 52.379251,    
  right: 40.220469,  
  bottom: 44.386416,
  left: 22.137157  
};

canvas.onload = function () {
    canvas.width = this.width * 2;
    canvas.height = this.height *2;
}

function groupData(data) {
    const groupedData = {};
  
    // group region
    for (const groupKey in data) {
      if (data.hasOwnProperty(groupKey)) {
        const groupData = data[groupKey];
  
        // group affected_type
        groupedData[groupKey] = {};
  
        groupData.forEach(item => {
          const typeKey = item.affected_type;
  
          if (!groupedData[groupKey][typeKey]) {
            groupedData[groupKey][typeKey] = [];
          }
  
          groupedData[groupKey][typeKey].push(item);
        });
      }
    }
  
    return groupedData;
  }

applyFilterButton.addEventListener("click", function () {

  const selectedEventTypes = getSelectedEventTypes();

  filterMapByEventTypes(selectedEventTypes);
});

const selectedEventTypes = getSelectedEventTypes();

filterMapByEventTypes(selectedEventTypes);


function filterMapByEventTypes(selectedEventTypes) {
    clearMap();
  
    for (const groupKey in groupedData) {
      if (groupedData.hasOwnProperty(groupKey)) {
        for (const groupKey2 in groupedData[groupKey]) {

          if (selectedEventTypes.includes(groupKey2)) {
            console.log(groupedData[groupKey][groupKey2].length);
            var color = "";
            var lengthPoint = groupedData[groupKey][groupKey2].length;
            if(groupKey2 == "30"){
              color = "rgba(26, 26, 26, 0.7)";
              const { x, y } = latLonToPixel(groupedData[groupKey][groupKey2][0].lat,groupedData[groupKey][groupKey2][0].lon);
              drawPoint(x, y,color,lengthPoint);
            } else if (groupKey2 == "31"){
              color = "rgba(240, 85, 46, 0.7)";
              const { x, y } = latLonToPixel(groupedData[groupKey][groupKey2][0].lat,groupedData[groupKey][groupKey2][0].lon);
              drawPoint(x, y,color,lengthPoint);
            } else if (groupKey2 == "32"){
              color = "rgba(133, 45, 23, 0.7)";
              const { x, y } = latLonToPixel(groupedData[groupKey][groupKey2][0].lat,groupedData[groupKey][groupKey2][0].lon);
              drawPoint(x, y,color,lengthPoint);
            } else if (groupKey2 == "33"){
              color = "rgba(255, 168, 0, 0.7)";
              const { x, y } = latLonToPixel(groupedData[groupKey][groupKey2][0].lat,groupedData[groupKey][groupKey2][0].lon);
              drawPoint(x, y,color,lengthPoint);
            } else if (groupKey2 == "34"){
              color = "rgba(118, 188, 227, 0.7)";
              const { x, y } = latLonToPixel(groupedData[groupKey][groupKey2][0].lat,groupedData[groupKey][groupKey2][0].lon,color);
              drawPoint(x, y,color,lengthPoint);
            }
            else {
              color = "rgba(235, 235, 235, 0.7)";
              const { x, y } = latLonToPixel(groupedData[groupKey][groupKey2][0].lat,groupedData[groupKey][groupKey2][0].lon,color,lengthPoint);
              drawPoint(x, y,color,lengthPoint);
            }
          }
        }
      }
    }
  }
function getSelectedEventTypes() {
  const selectedEventTypes = [];

  if (document.getElementById("eventType30").checked) {
    selectedEventTypes.push("30");
  }
  if (document.getElementById("eventType31").checked) {
    selectedEventTypes.push("31");
  }
  if (document.getElementById("eventType32").checked) {
    selectedEventTypes.push("32");
  }
  if (document.getElementById("eventType33").checked) {
    selectedEventTypes.push("33");
  }
  if (document.getElementById("eventType34").checked) {
    selectedEventTypes.push("34");
  }

  return selectedEventTypes;
}



function latLonToPixel(lat, lon) {
  const x = (lon - UKRAINE_RECT.left) / (UKRAINE_RECT.right - UKRAINE_RECT.left) * canvas.width;
  const y = (UKRAINE_RECT.top - lat) / (UKRAINE_RECT.top - UKRAINE_RECT.bottom) * canvas.height;
  return { x, y };
}

// Function for drawing a point on the canvas
function drawPoint(x, y, color, lengthPoint) {
  ctx.beginPath();
  var radius = lengthPoint*0.02;
  if(radius<14) {
    radius = 14;
  }
  ctx.arc(x, y, radius, 0, Math.PI * 2);
  ctx.fillStyle = color; // color points
  ctx.strokeStyle = "#ffffff"; // color border
  ctx.stroke();
  ctx.fill();
  ctx.closePath();
    ctx.fillStyle = "#fff";
    ctx.font = "12px uk"; 
    ctx.textAlign = "center"; 
    ctx.fillText(lengthPoint, x, y+6);
}

function clearMap() {
    ctx.clearRect(0, 0, 1300, 900);
  }