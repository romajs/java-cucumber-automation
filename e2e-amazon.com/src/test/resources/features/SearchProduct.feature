#language:en

Feature: Search product

	Scenario: Customer search for product
		Given customer access "home" page
		When searches for "Chia Pet Gremlin"
		Then verify that products result list is greater or equal than 1
		When looking for product with title containing "Chia Pet Gremlin Decorative Pottery Planter, Gizmo"
		Then verify that product price is "$19.99"

	