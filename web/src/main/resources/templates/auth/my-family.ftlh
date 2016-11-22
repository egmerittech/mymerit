<#import "/macros/template.ftlh" as template/>
<@template.render pagetitle="Your Family">
	<h2>${family.familyName}</h2>
	<div>
		<h3>Family Members</h3>
		<p>Add your family so everybody gets their own sign-in and profile.</p>

		<div class="row">
			<div class="list-group">
				<#list family.familyMembers as familyMember>
					<#if familyMember.familyMemberType == 'PARENT'><#assign css='panel-primary'/><#else/><#assign css='panel-info'/></#if>
					<#if familyMember.familyMemberType == 'PARENT'><#assign glyph='fa-user-secret'/><#else/><#assign glyph='fa-child'/></#if>
					<div class="col-md-4">
						<div class="panel ${css}">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa ${glyph} fa-fw"></i> ${familyMember.user.firstname} ${familyMember.user.lastname}
								</h3>
							</div>
							<div class="panel-body">
								<dl>
									<dt>Current balance:</dt>
									<dd>$${familyMember.meritAccount.balance?string["0.00"]}</dd>
									
									<dt>Total spent:</dt>
									<dd>$${0?string["0.00"]}</dd>
								</dl>
							</div>
							<div class="panel-footer text-right">
								<button type="button" class="btn btn-default"><i class="fa fa-history fa-fw"></i></button>
								<button type="button" class="btn btn-primary"><i class="fa fa-pencil-square-o fa-fw"></i></button>
							</div>
						</div>
					</div>
				</#list>
			</div>
		</div>		
		
		<button href="#" class="btn btn-primary btn-lg"><i class="fa fa-users fa-fw"></i> Add a family member</button>
	</div>

	<div>
		<h3>Other People</h3>
		<p>
			Allow people who are not a part of your immediate family to sign-in with their own accounts. Although they will not be listed
			as family members, they can approve rewards for your children.
		</p>

		<button href="#" class="btn btn-primary btn-lg"><i class="fa fa-users fa-fw"></i> Add another person</button>
	</div>
</@template.render>