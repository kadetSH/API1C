package com.example

import com.example.jsonMy.*
import io.ktor.application.call
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.request.path
import io.ktor.request.receive
import io.ktor.response.respondFile
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.post
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

val sdf = SimpleDateFormat("dd/M/yyyy HH:mm:ss")
const val hostDefault = "http://192.168.173.101/StomWork/hs"

fun Routing.authGetUI(client: HttpClient) {
    post("AuthGetUI") {
        val inJSON = call.receive<AuthorizationJS>()
        if (inJSON.Name != null && inJSON.Patronymic != null && inJSON.Password != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("Ответ на AuthGetUI - $currentDate")
        }
    }
}

fun Routing.patientDataRequest(client: HttpClient) {
    post("PatientDataRequest") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на PatientDataRequest - $currentDate")
        }
    }
}

fun Routing.xRaysListRequest(client: HttpClient) {
    post("/XRaysListRequest") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на XRaysListRequest - $currentDate")
        }
    }
}

fun Routing.loaderPhotoXRays(client: HttpClient) {
    post("/LoaderPhotoXRays") {
        val inJSON = call.receive<NumberXRaysJS>()
        if (inJSON.numberXRays != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            val photoPath = stringRequest.substring(1, stringRequest.length - 1)
            val file = File(photoPath)
            call.respondFile(file)
            val currentDate = sdf.format(Date())
            println("ответ на LoaderPhotoXRays - $currentDate")
        }
    }
}

fun Routing.passwordRequest(client: HttpClient) {
    post("/PasswordRequest") {
        val inJSON = call.receive<SearchKlientJS>()
        if (inJSON.surname != null && inJSON.name != null && inJSON.patronymic != null && inJSON.telephone != null && inJSON.Birth != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на PasswordRequest - $currentDate")
        }
    }
}

fun Routing.contractsRequest(client: HttpClient) {
    post("/ContractsRequest") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на ContractsRequest - $currentDate")
        }
    }
}

fun Routing.visitHistoryRequest(client: HttpClient) {
    post("/VisitHistoryRequest") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на VisitHistoryRequest - $currentDate")
        }
    }
}

fun Routing.picturesVisitListRequest(client: HttpClient) {
    post("/PicturesVisitListRequest") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на PicturesVisitListRequest - $currentDate")
        }
    }
}

fun Routing.radiationDoseListRequest(client: HttpClient) {
    post("/RadiationDoseListRequest") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на RadiationDoseListRequest - $currentDate")
        }
    }
}

fun Routing.loaderPicturesVisit(client: HttpClient) {
    post("/LoaderPicturesVisit") {
        val inJSON = call.receive<NumberPicturesVisitJS>()
        if (inJSON.numberPicturesVisit != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            val photoPath = stringRequest.substring(1, stringRequest.length - 1)
            val file = File(photoPath)
            call.respondFile(file)
            val currentDate = sdf.format(Date())
            println("ответ на LoaderPicturesVisit - $currentDate")
        }
    }
}

fun Routing.officeHours(client: HttpClient) {
    post("/OfficeHours") {
        val inJSON = call.receive<DepartmentJS>()
        if (inJSON.department != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на OfficeHours - $currentDate")
        }
    }
}

fun Routing.doctorRequests(client: HttpClient) {
    post("/DoctorRequests") {
        val inJSON = call.receive<RequestDoctorRequestsJS>()
        if (inJSON.doctor != null && inJSON.date != null && inJSON.periodOfTime != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на DoctorRequests - $currentDate")
        }
    }
}

fun Routing.createAnAppointment(client: HttpClient) {
    post("/CreateAnAppointment") {
        val inJSON = call.receive<CreateAnAppointmentJS>()
        if (inJSON.patientUI != null && inJSON.doctorFIO != null && inJSON.dateOfReceipt != null && inJSON.timeOfReceipt != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на CreateAnAppointment - $currentDate")
        }
    }
}

fun Routing.listOfApplicationsRequest(client: HttpClient) {
    post("/ListOfApplicationsRequest") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на ListOfApplicationsRequest - $currentDate")
        }
    }
}

fun Routing.listOfNewsRequest(client: HttpClient) {
    post("/LoaderNews") {
        val put = this.context.request.path()
        val stringRequest = client.post<HttpResponse>(hostDefault + put) {
        }.readText()
        call.respondText(stringRequest)
        val currentDate = sdf.format(Date())
        println("ответ на LoaderNews - $currentDate")
    }
}

fun Routing.loaderPicturesNews() {
    post("/LoaderPicturesNews") {
        val inJSON = call.receive<ImagePathJS>()
        if (inJSON.imagePath != null) {
            val photoPath = inJSON.imagePath
            val file = File(photoPath)
            call.respondFile(file)
            val currentDate = sdf.format(Date())
            println("ответ на LoaderPicturesNews - $currentDate")
        }
    }
}

//Новая версия

fun Routing.passwordRequest2(client: HttpClient) {
    post("/PasswordRequest2") {
        val inJSON = call.receive<SearchKlientJS2>()
        if (inJSON.surname != null && inJSON.name != null && inJSON.patronymic != null && inJSON.telephone != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на PasswordRequest2 - $currentDate")
        }
    }
}

fun Routing.patientDataRequest2(client: HttpClient) {
    post("PatientDataRequest2") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на PatientDataRequest2 - $currentDate")
        }
    }
}

fun Routing.listOfNewsClientRequest(client: HttpClient) {
    post("/LoaderNewsClient") {
        val inJSON = call.receive<PatientUiJS>()
        if (inJSON.patientUI != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на LoaderNewsClient - $currentDate")
        }
    }
}

fun Routing.officeHours2(client: HttpClient) {
    post("/OfficeHours2") {
        val inJSON = call.receive<DepartmentJS2>()
        if (inJSON.department != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на OfficeHours2 - $currentDate")
        }
    }
}

fun Routing.loaderDoctorsList(client: HttpClient) {
    post("/DoctorsListRequest") {
        val put = this.context.request.path()
        val stringRequest = client.post<HttpResponse>(hostDefault + put) {
        }.readText()
        call.respondText(stringRequest)
        val currentDate = sdf.format(Date())
        println("ответ на DoctorsListRequest - $currentDate")
    }
}

fun Routing.officeHours2Doctors(client: HttpClient) {
    post("/OfficeHours2Doctors") {
        val inJSON = call.receive<DoctorFIO>()
        if (inJSON.docFIO != null) {
            val put = this.context.request.path()
            val stringRequest = client.post<HttpResponse>(hostDefault + put) {
                body = inJSON
            }.readText()
            call.respondText(stringRequest)
            val currentDate = sdf.format(Date())
            println("ответ на OfficeHours2Doctors - $currentDate")
        }
    }
}

