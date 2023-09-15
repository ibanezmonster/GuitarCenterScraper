function demo(){
	alert("Search complete. Please search again and results will update.")
}

function currentInstrument()
{
	var select = document.getElementById('instrumentType');
	var instrumentSelection = select.options[select.selectedIndex].value;
	var instrumentDisplay = document.getElementById('current-instrument');
	
	if(instrumentDisplay == '8-string Electric Guitar'){instrumentDisplay.innerHTML = '8-string Electric Guitar'}
	else if(instrumentDisplay == '7-string Electric Guitar'){instrumentDisplay.innerHTML = '7-string Electric Guitar'}
	else if(instrumentDisplay == 'Acoustic Guitar'){instrumentDisplay.innerHTML = 'Acoustic Guitar'}
}