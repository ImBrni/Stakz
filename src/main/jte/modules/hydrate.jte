@param casino.model.AppUser currentUser

<script>
     document.getElementById("balance").innerHTML = "${currentUser.getBalanceFmt()}"

    <script>
    (function() {
        const div = document.getElementById('myDiv');
        if (div) {
            div.innerHTML = "${currentUser.getBalanceFmt()}"
        } else {
            console.warn('Div not found!');
        }
    })();
</script>
 </script>