package com.example


import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.coroutines.*
import java.util.*

//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 6792, host = "0.0.0.0") {
        module()
    }.start(wait = true)
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    val hostDefault = "http://192.168.173.101/StomWork/hs"
    val client = HttpClient(CIO) {
        defaultRequest {
            headers {
                header("Authorization", "Basic " + Base64.getEncoder().encodeToString("web:123".toByteArray()))
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }

        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }
    runBlocking {
        // Sample for making a HTTP Client request
        /*
        val message = client.post<JsonSampleClass> {
            url("http://127.0.0.1:8080/path/to/endpoint")
            contentType(ContentType.Application.Json)
            body = JsonSampleClass(hello = "world")
        }
        */
    }

    install(Routing){
        this.authGetUI(client)
        this.patientDataRequest(client)
        this.xRaysListRequest(client)
        this.loaderPhotoXRays(client)
        this.passwordRequest(client)
        this.contractsRequest(client)
        this.visitHistoryRequest(client)
        this.picturesVisitListRequest(client)
        this.radiationDoseListRequest(client)
        this.loaderPicturesVisit(client)
        this.officeHours(client)
        this.doctorRequests(client)
        this.createAnAppointment(client)
        this.listOfApplicationsRequest(client)
        this.listOfNewsRequest(client)
        this.loaderPicturesNews()
        //Новый вариант
        this.passwordRequest2(client)
        this.patientDataRequest2(client)
        this.listOfNewsClientRequest(client)
        this.officeHours2(client)
        this.loaderDoctorsList(client)
        this.officeHours2Doctors(client)
    }



}



