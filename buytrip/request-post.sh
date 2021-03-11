curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"ticketCode":"123","cardNumber":"123","securityNumberCode":"123","ticketValue":"1000"}' \
  http://api-buytrip/buys



curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"cardNumber":"123","securityNumberCode":"123","creditValue":"10000"}' \
  http://api-bank/cards
