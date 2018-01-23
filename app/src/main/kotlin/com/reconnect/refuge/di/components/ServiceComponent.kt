package com.reconnect.refuge.di.components

import com.reconnect.refuge.di.modules.ServiceModule
import com.reconnect.refuge.di.scopes.ServiceScope
import dagger.Component

/**
 * @author lusinabrian on 17/08/17.
 * @Notes Connector between BaseService module and service dependencies
 * Services will be injected
 */
@ServiceScope
@Component(modules = [(ServiceModule::class)])
interface ServiceComponent