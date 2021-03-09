curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"ticketCode":"123","cardNumber":"123","securityNumberCode":"123","ticketValue":"1000"}' \
  http://service-ms-buytrip:8080/buys
