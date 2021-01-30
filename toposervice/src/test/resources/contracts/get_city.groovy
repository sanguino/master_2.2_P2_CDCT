import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return the city and the orography"
    request {
        url "/api/topographicdetails/Madrid"
        method GET()
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(id: "Madrid", landscape: "Flat")
        status(200)
    }
}