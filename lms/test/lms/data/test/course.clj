(ns lms.data.test.course)

(def course 
	{
		:id 1
		:node-type "branch"
		:children [
			{:id 2 :node-type "branch" :content-type "branch" :children [
				{
					:id 3 
					:node-type "leaf" 
					:content-type "text" 
					:time 7 
					:children []
				}
				{
					:id 4 
					:node-type "leaf" 
					:content-type "text" 
					:time 27 
					:children []
				}
			]}
		]
	}
)
