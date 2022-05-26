<html>
<body>
<h2>Project Purple Cow</h2>

<table>
<tr><td>The current counter number:</td><td><b><p id="counterValue">Unknown</p></b></td></tr>
</table>

<p><button onClick="getCounterDirectly()">Click for JSON response</button></p>
<p><button onClick="getRestCounter()">Click for text response</button></p>

<script>
    async function getCounterDirectly() {
        let response = await fetch('https://api.countapi.xyz/hit/edbrown-submission/1ccb732e-b55a-4404-ad3f-0f99c02fe44e');
        let data = await response.text();
        document.getElementById("counterValue").innerHTML = data;
    }

    async function getRestCounter() {
        let response = await fetch('api/counter-int');
        let data = await response.text();
        document.getElementById("counterValue").innerHTML = data;
    }
</script>
</body>
</html>
