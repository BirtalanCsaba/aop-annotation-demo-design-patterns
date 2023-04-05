package ro.ubbcluj.aopdemo.business.dto

import java.io.Serializable

abstract class BaseDto<ID: Serializable> {
    var id: ID? = null
}