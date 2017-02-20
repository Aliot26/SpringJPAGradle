const url = 'users.json';
const div = document.getElementsByTagName("div")[0];

const updateValue = value => {
    div.innerText = value;
};
const errorHandler = value => updateValue("Error" + value);


fetch(url)
    .then(function(response) {
        alert(response.headers.get('Content-Type')); 
        alert(response.status); 
        return response.text();
    })
    .then(function(data) {
    	updateValue(data);
    	console.log(data);
    })
    .catch(alert);
