(ns lms.reduce)

;; assign time to each node. 
;; if node (children empty), time is time-taken
;; if branch, time is sum of children.
(defn t
	([node]
		(if (empty? (get node :children []))
			(get node :time 0)
			(reduce t 0 (get node :children))
		))
	([time node]
		(if (empty? (get node :children []))
			(+ time (get node :time 0))
			(+ time (t node))))
)
