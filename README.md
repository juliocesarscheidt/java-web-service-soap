# Java Web Service SOAP

Simple Java WS using SOAP

WSDLs:
<http://127.0.0.1:9090/calculatorWS?wsdl>
<http://127.0.0.1:9090/itemWS?wsdl>

```bash
######## Calculator WS ########

# Sum Action
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
  --url 'http://127.0.0.1:9090/calculatorWS'

# response
# <?xml version='1.0' encoding='UTF-8'?>
#   <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
#   <S:Body>
#     <ns2:sumResponse xmlns:ns2="http://services.juliocesarscheidt.github.com/">
#       <sum>
#         <value>12.0</value>
#         <kind>sum</kind>
#       </sum>
#     </ns2:sumResponse>
#   </S:Body>
# </S:Envelope>


######## Item WS ########

# Create Item
DATA=$(cat <<EOF
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://services.juliocesarscheidt.github.com/">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:createItem>
      <item>
        <id>10</id>
        <name>Item 10</name>
        <price>100.00</price>
      </item>
    </ws:createItem>
  </soapenv:Body>
</soapenv:Envelope>
EOF
)
# echo "${DATA}"

curl --silent -X POST \
  -H 'Content-Type: text/xml' \
  -d "${DATA}" \
  --url 'http://127.0.0.1:9090/itemWS'

# <?xml version='1.0' encoding='UTF-8'?>
#   <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
#   <S:Body>
#     <ns2:createItemResponse xmlns:ns2="http://services.juliocesarscheidt.github.com/">
#       <created>
#         <id>10</id>
#         <name>Item 10</name>
#         <price>100.0</price>
#       </created>
#     </ns2:createItemResponse>
#   </S:Body>
# </S:Envelope>
```
