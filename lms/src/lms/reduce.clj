(ns lms.reduce)

;; assign time to each node. 
;; if node (children empty), time is time-taken
;; if branch, time is sum of children.
(defn calculate-time
	([node]
		(if (empty? (get node :children []))
			(get node :time 0)
			(reduce calculate-time 0 (get node :children))
		))
	([time node]
		(if (empty? (get node :children []))
			(+ time (get node :time 0))
			(+ time (calculate-time node))))
)

(defn assign-time
	[course]
	(let [
		course-updated 			
			(assoc course :time (calculate-time course))
		]
		(if (empty? (get course-updated :children []))
			course-updated
			(assoc 
				course-updated 
				:children
					(map assign-time (course-updated :children)))
		)
	)
	
)

