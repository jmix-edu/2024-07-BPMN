package com.company.bpmdemo.security;

import com.company.bpmdemo.entity.OrderLine;
import com.company.bpmdemo.entity.PizzaOrder;
import com.company.bpmdemo.entity.PizzaType;
import com.company.bpmdemo.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "PizzaProcessActorRole", code = PizzaProcessActorRole.CODE, scope = "UI")
public interface PizzaProcessActorRole {
    String CODE = "pizza-process-actor-role";

    @EntityAttributePolicy(entityClass = User.class, attributes = {"*"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();

    @MenuPolicy(menuIds = "User.list")
    void screens();

    @ViewPolicy(viewIds = "*")
    void view();

    @EntityAttributePolicy(entityClass = OrderLine.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = OrderLine.class, actions = EntityPolicyAction.ALL)
    void orderLine();

    @EntityAttributePolicy(entityClass = PizzaOrder.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = PizzaOrder.class, actions = EntityPolicyAction.ALL)
    void pizzaOrder();

    @EntityAttributePolicy(entityClass = PizzaType.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = PizzaType.class, actions = EntityPolicyAction.ALL)
    void pizzaType();
}