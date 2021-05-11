# Java Web Service SOAP

wsdl :: <http://127.0.0.1:8090/calculator?wsdl>

```bash
## Sum
DATA=$(cat <<EOF
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://services.juliocesarscheidt.github.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:sum>
         <arg0>2</arg0>
         <arg1>10</arg1>
      </ws:sum>
   </soapenv:Body>
</soapenv:Envelope>
EOF
)
# echo "${DATA}"

curl --silent -X POST \
  -H 'Content-Type: text/xml' \
  -d "${DATA}" \
  --url 'http://127.0.0.1:8090/calculator'

# response
# <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
#    <S:Body>
#       <ns2:sumResponse xmlns:ns2="http://services.juliocesarscheidt.github.com/">
#          <return>
#             <value>12.0</value>
#             <kind>sum</kind>
#          </return>
#       </ns2:sumResponse>
#    </S:Body>
# </S:Envelope>


## Subtraction
DATA=$(cat <<EOF
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://services.juliocesarscheidt.github.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:subtraction>
         <arg0>12</arg0>
         <arg1>8</arg1>
      </ws:subtraction>
   </soapenv:Body>
</soapenv:Envelope>
EOF
)
# echo "${DATA}"

curl --silent -X POST \
  -H 'Content-Type: text/xml' \
  -d "${DATA}" \
  --url 'http://127.0.0.1:8090/calculator'

# response
# <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
#    <S:Body>
#       <ns2:subtractionResponse xmlns:ns2="http://services.juliocesarscheidt.github.com/">
#          <return>
#             <value>4.0</value>
#             <kind>subtraction</kind>
#          </return>
#       </ns2:subtractionResponse>
#    </S:Body>
# </S:Envelope>
```
